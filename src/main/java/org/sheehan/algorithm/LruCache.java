package org.sheehan.algorithm;

import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by bsheehan on 1/25/16.
 *
 * Assumptions
 *
 * 1. that each key read is a unique value and populates the hasmap up to full load (1.0)
 * 2. After that LRU eviction takes place and the cache is therefore fixed size
 *
 * Look at LinkedHashMap which allows override of removeEldestEntry method for stale cache updates. This might suffice instead of this homegrown approach.
 */
public class LruCache {
    static public final int MAX = 10; //max before eviction
    private Map<String, String> cache = new HashMap<>(MAX, 1.0f); // use full cache
    private int size = 0;

    class LruNode implements Comparable<LruNode> {

        Timestamp ts;
        String key;

        public int compareTo(LruNode other) {
            //return other.ts.compareTo(this.ts);
            return this.ts.compareTo(other.ts);

        }

        public String toString(){
            return this.ts.toString() + " " + this.key;
        }
    }

    private SortedSet<LruNode> lruSet = new TreeSet<>();

    Logger log = Logger.getLogger(this.getClass().getName());

    public String read(String key) {

        // we always update the timestamp sortedset
        java.util.Date date= new java.util.Date();
        LruNode newNode = new LruNode();
        newNode.ts = new Timestamp(date.getTime());
        newNode.key = key;

        // if not in cache then put it on in.
        String val = cache.get(key);
        if (val == null)
        {
            //1. load cache with something
            //  a. check size
            //  b. if >=max get lru key
                    // else put into cache
            //  c. replace

            // todo just mocking out a value to cache for now
            val = UUID.randomUUID().toString();

            if (size < MAX) {
                cache.put(key, val);
                log.info("wrote new cache value: " + key + " " + cache.get(key));
                size++;
                newNode.key = key; // last updated index
            } else {
                // get lru index for replacement then dequeue
                LruNode lruNode = lruSet.first();
                log.info("lruSet removed: " + lruNode.key);
                lruSet.remove(lruNode);

                log.info("removing cache at index: " + lruNode.key);
                cache.remove(lruNode.key);

                log.info("added cache at index: " + key + " " + val);
                cache.put(key, val); //update at lru index

            }
        } else {
            // simply update the cache hit timestamp in lru set
        }


        //if already in lru set need to update that by removing and adding new timestamp for that key
        Iterator<LruNode> iterator = lruSet.iterator();
        while (iterator.hasNext()) {
            LruNode node = iterator.next();
            if (node.key.equals(newNode.key)) {
                iterator.remove();
                log.info("lruSet removed: " + newNode.key);
            }
        }

        log.info("lruSet added: " + newNode.key);
        lruSet.add(newNode); //update PQ

        log.info("LRU UPDATED: " + lruSet.toString());

        return val;

    }

}
