package com.rateLimiter;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {

    private static long INTERVAL = 1000l;
    private static int QUERIES_PER_INTERVAL = 3;

    private Map<Integer, Deque> consumedLimitForCustomers = new HashMap<>();

    public RateLimiter() {

    }

    boolean rateLimit(int customerId) {

        if (customerId <= 0) {
            return false;
        }

        //4321 - 4
        long currentTimeStamp = getCurrentTime();

        Deque<Long> customerData = consumedLimitForCustomers.get(customerId);
        if (customerData == null) {
            customerData = new LinkedList<>();
            customerData.addLast(currentTimeStamp);
            consumedLimitForCustomers.put(customerId, customerData);
        } else {
            long lastWindow = currentTimeStamp - INTERVAL;

            //remove last window data
            while (!customerData.isEmpty() && customerData.peekFirst() <= lastWindow) {
                customerData.removeFirst();
            }

            //check current window size
            int exhaustedLimit = customerData.size();

            //insert or rate limit
            if (exhaustedLimit >= QUERIES_PER_INTERVAL) {
                return false;
            } else {
                customerData.addLast(currentTimeStamp);
            }
        }

        return true;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
