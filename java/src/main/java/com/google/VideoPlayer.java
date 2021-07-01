package com.google;
import java.util.*;

import java.util.stream.Collectors;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Video currentVideo;
  private boolean pause;
  private List<Video> sortedVideos;


  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.currentVideo = null;
    this.pause = false;
    this.sortedVideos = videoLibrary.getVideos().stream().sorted(Comparator.comparing(Video::getTitle)).collect(Collectors.toList());

  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    for (Video video : sortedVideos)
      System.out.println(video.getTitle() +" (" + video.getVideoId() + ") " + video.getTags().toString().replace(",", ""));
  }

  public void playVideo(String videoId) {
    pause = false;
    if(currentVideo == null && sortedVideos.stream().anyMatch(video -> video.getVideoId().equals(videoId))){
      currentVideo = sortedVideos.stream().filter(video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
      System.out.println("Playing video: " + currentVideo.getTitle());
    } else if(currentVideo != null && ! sortedVideos.stream().noneMatch(video -> video.getVideoId().equals(videoId))){
      System.out.println("Stopping video: " + currentVideo.getTitle());
      currentVideo = sortedVideos.stream().filter(video -> video.getVideoId().equals(videoId)).findAny().orElse(null);
      System.out.println("Playing video: " + currentVideo.getTitle());
    } else{
      System.out.println("Cannot play video: Video does not exist");
    }
  }


  public void stopVideo() {

    if(currentVideo != null){
      System.out.println("Stopping video: " + currentVideo.getTitle());
      currentVideo = null;
    } else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    pause = false;
    Random rand = new Random();
    int randomId = rand.nextInt(videoLibrary.getVideos().size() + 1);
    if (currentVideo == null) {
      playVideo(sortedVideos.get(randomId).getVideoId());
    }
    else {
      stopVideo();
      playVideo(sortedVideos.get(randomId).getVideoId());
    }
  }

  public void pauseVideo() {
    if(currentVideo != null){
      if(!pause){
        pause = true;
        System.out.println("Pausing video: " + currentVideo.getTitle());
      } else if (pause){
        System.out.println("Video already paused: " + currentVideo.getTitle());
      }
    }else{
      System.out.println("Cannot pause video: No video is currently playing");
    }
  }

  public void continueVideo() {
    if(currentVideo != null){
      if(pause){
        System.out.println("Continuing video: " + currentVideo.getTitle());
        pause = false;
      } else {
        System.out.println("Cannot continue video: Video is not paused");
      }
    } else{
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if(currentVideo != null){
      String pauseStatus;
      if(!pause){
        pauseStatus = "";
      } else{
        pauseStatus = " - PAUSED";
      }
      System.out.println("Currently playing: " + currentVideo.getTitle() + " (" + currentVideo.getVideoId() + ") [" + currentVideo.getTags().stream().collect(Collectors.joining(" ")) + "]"+ pauseStatus);
    } else{
      System.out.print("No video is currently playing");
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}