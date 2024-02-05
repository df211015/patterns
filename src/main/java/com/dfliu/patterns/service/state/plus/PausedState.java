package com.dfliu.patterns.service.state.plus;

public class PausedState implements MediaPlayerState {
    private MediaPlayer mediaPlayer;

    public PausedState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        this.mediaPlayer.setState(this.mediaPlayer.getPlayingState());
        System.out.println("Playing");
    }

    @Override
    public void pause() {
        System.out.println("Already paused");
    }

    @Override
    public void stop() {
        this.mediaPlayer.setState(this.mediaPlayer.getStoppedState());
        System.out.println("Stopped");
    }
}
