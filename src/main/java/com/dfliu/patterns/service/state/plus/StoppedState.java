package com.dfliu.patterns.service.state.plus;

public class StoppedState implements MediaPlayerState {
    private MediaPlayer mediaPlayer;

    public StoppedState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        this.mediaPlayer.setState(this.mediaPlayer.getPlayingState());
        System.out.println("Playing");
    }

    @Override
    public void pause() {
        System.out.println("Can not pause");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped");
    }
}