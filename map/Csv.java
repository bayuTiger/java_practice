package map;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Csv {

  private String path;

  public Csv(String path) {
    this.path = path;
  }

  // public String getPath() {
  //   return this.path;
  // }

  // public void setPath(String path) {
  //   this.path = path;
  // }

  public Path read() {
    Path file = Paths.get(path);
    return file;
  }
}
