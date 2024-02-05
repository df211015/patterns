package com.dfliu.patterns.service.state.plus;

public class MediaPlayer {
    public MediaPlayerState getPlayingState() {
        return this.playingState;
    }

    public MediaPlayerState getPauseState() {
        return this.pauseState;
    }

    public MediaPlayerState getStoppedState() {
        return this.stoppedState;
    }

    private MediaPlayerState playingState;
    private MediaPlayerState pauseState;
    private MediaPlayerState stoppedState;

    private MediaPlayerState currentState;

    public MediaPlayer() {
        this.playingState = new PlayingState(this);
        this.pauseState = new PausedState(this);
        this.stoppedState = new StoppedState(this);

        this.currentState = this.stoppedState;
    }

    public void setState(MediaPlayerState state) {
        this.currentState = state;
    }

    public void play() {
        this.currentState.play();
    }

    public void pause() {
        this.currentState.pause();
    }

    public void stop() {
        this.currentState.stop();
    }
}