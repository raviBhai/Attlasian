package com.rateLimiter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RateLimiterTest {

    @Test
    public void when_requestsExceedTheRate_then_rateLimit() {

        RateLimiter rateLimiter = new RateLimiter();
        int customerID = 1;
        boolean result = true;

        for (int i = 0; i < 4; i++) {
            result = rateLimiter.rateLimit(customerID);
        }

        assertTrue(!result);

    }

    @Test
    public void when_requestsDoNotExceedTheRate_then_allow() throws Exception {
        RateLimiter rateLimiter = new RateLimiter();
        int customerID = 1;

        boolean result = false;

        for (int i = 0; i < 3; i++) {
            result = rateLimiter.rateLimit(customerID);
        }
        assertTrue(result);

        Thread.sleep(2000);

        for (int i = 0; i < 4; i++) {
            result = rateLimiter.rateLimit(customerID);
        }

        assertTrue(!result);
    }
}
