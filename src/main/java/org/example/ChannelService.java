package org.example;

import org.example.observer.Observer;
import org.example.subject.Channel;
import org.example.subject.Subject;

import java.util.*;

public class ChannelService {
    private final Map<String, Channel> channels = new HashMap<>();

    public boolean createChannel(String channel) {
        if (channel == null || channel.trim().isEmpty() ||channels.containsKey(channel)){
            return false;
        }
        channels.put(channel,new Channel(channel));
        return true;
    }

    public boolean deleteChannel(String channel) {
        if (channels.containsKey(channel)){
            channels.remove(channel);
            return true;
        }
        return false;
    }
    public Optional<Channel> getChannel(String name){
        return Optional.ofNullable(channels.get(name));
    }


    public boolean subscribe(String channelName, Observer user){
        if (channels.containsKey(channelName)){
            channels.get(channelName).subscribe(user);
            return true;
        }
        return false;
    }
    public boolean unsubscribe(String channelName, Observer user){
        if (channels.containsKey(channelName)){
            channels.get(channelName).unsubscribe(user);
            return true;
        }
        return false;
    }

    public boolean upload(String channelName, String videoTitle){
        if (channels.containsKey(channelName)){
            channels.get(channelName).uploadVideo(videoTitle);
            return true;
        }
        return false;
    }

    public Set<String> listChannels() {
        return new HashSet<>(channels.keySet());
    }


    public void newContentNotification(Channel channel, String message) {
        // TODO: implement
    }
}
