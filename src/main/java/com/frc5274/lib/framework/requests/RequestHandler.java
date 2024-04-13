package com.frc5274.lib.framework.requests;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RequestHandler {
    
    public List<Request> requestQueue = new ArrayList<Request>();
    public List<Request> requestCache = new ArrayList<Request>();
    public Timer runtime = new Timer();

    private void addRequestToCache(Request request) {
        request.initialize();
        request.isQueued = false;
        requestCache.add(request);
    }
    
    public void queueRequest(Request request) {
        request.isQueued = true;
        requestQueue.add(request);
    }

    public void readScheduler() {
        for(Request queuedRequest : requestQueue) {
            if(runtime.hasElapsed(queuedRequest.startTimestamp)) {
                
                for(Request cachedRequest : requestCache) {
                    for(SubsystemBase usedSubsystem : cachedRequest.usedSubsystems) {
                        for(SubsystemBase queuedSubsystem : queuedRequest.usedSubsystems) {
                            if(queuedSubsystem == usedSubsystem) {
                                requestCache.remove(cachedRequest);
                                requestCache.add(queuedRequest);
                            } else {
                                requestCache.add(queuedRequest);
                            }
                        }
                    }
                }

                requestQueue.remove(queuedRequest);
            }
        }
    }
}
