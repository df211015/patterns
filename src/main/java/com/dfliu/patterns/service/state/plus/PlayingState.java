package com.dfliu.patterns.service.state.plus;

public class PlayingState implements MediaPlayerState {
    private MediaPlayer mediaPlayer;

    public PlayingState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        System.out.println("Already playing");
    }

    @Override
    public void pause() {
        this.mediaPlayer.setState(this.mediaPlayer.getPlayingState());
        System.out.println("Paused");
    }

    @Override
    public void stop() {
        this.mediaPlayer.setState(this.mediaPlayer.getStoppedState());
        System.out.println("Stopped");
    }
}