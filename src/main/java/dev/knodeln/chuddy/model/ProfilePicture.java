package dev.knodeln.chuddy.model;

public class ProfilePicture {

  private String path;

  ProfilePicture(String path) {
    this.path = path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getPath() {
    return this.path;
  }
}
