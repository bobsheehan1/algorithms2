package org.sheehan.algorithm;

import junit.framework.TestCase;

import java.util.logging.Logger;

/**
 * Created by bsheehan on 1/25/16.
 */
public class LruCacheTest extends TestCase {

    Logger log = Logger.getLogger(this.getClass().getName());

    public void testRead() throws Exception {

        LruCache cache = new LruCache();

        //lOAD CACHE
        for (int i = 0; i < LruCache.MAX; ++i){
            String key = "test" + i;
            String val = cache.read(key);
            log.info("TEST CACHE ADD " + key + " " + val);
            Thread.sleep(100);
        }

        log.info("TEST 1 --------------- READ key = test0, --> test1 should be oldest");

        // read entry to update ts for this key
        String key = "test0";
        String val = cache.read(key);
        log.info("TEST CACHE READ " + key + " " + val);

        log.info("TEST 2 --------------- READ key = test-new --> should evict test1");
        // read uncached entry to see if LRU uses test1 lru index
        key = "test-new";
        val = cache.read(key);
        log.info("TEST 3 --------------- ADD LRU INDEX (test-new is newest in lruset) " + key + " " + val);

    }
}