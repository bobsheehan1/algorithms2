package org.sheehan.algorithm;

import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueListImpl;

import java.sql.Timestamp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

/**
 * Created by bsheehan on 1/25/16.
 *
 * Assumptions
 *
 * THREAD SAFE ?
 *
 * Look at LinkedHashMap which allows override of removeEldestEntry method for stale cache updates.
 * This might suffice instead of this homegrown approach.
 */
public class LruCache<K,V> {

    private Map<K, V> cache;

    private java.util.Queue lruQueue = new ConcurrentLinkedQueue();

    Logger log = Logger.getLogger(this.getClass().getName());

    public final int capacity;

    public LruCache(int capacity){
        cache = new ConcurrentHashMap<>(capacity, 1.0f);
        this.capacity = capacity;
    }

    // either update or add to cache. handle lru update if at capacity
    public void put(K key, V val) {
        if (lruQueue.size() >= capacity){
            K lruKey = (K)lruQueue.poll();
            cache.remove(lruKey);
            log.info("evicted "+ lruKey);
        }
        cache.put(key, val);
        lruQueue.add(key);
        log.info ("PUT " + lruQueue.toString());
    }

    public V get(K key) {
        V value = cache.get(key);

        if (lruQueue.contains(key)) {
            lruQueue.remove(key);
            lruQueue.add(key);
        }
        log.info ("GET " + lruQueue.toString());

        return value;
    }

    public V remove(K key){
        V val = null;
        if (cache.containsKey(key)) {
            val = cache.remove(key);
        }
        if (lruQueue.contains(key))
            lruQueue.remove(key);

        log.info ("REMOVE " + lruQueue.toString());

        return val;
    }
}
