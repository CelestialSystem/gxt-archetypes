package org.gonevertical.archetypes.generator.utils;

import org.apache.commons.io.DirectoryWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileRegex extends DirectoryWalker<File> {

  private String name;
  private String regexFind;

  public FileRegex(String name, String regexFind) {
    super();
    
    this.name = name;
    this.regexFind = regexFind;
  }

  public List<File> start(File startDirectory) {
    List<File> results = new ArrayList<File>();
    try {
      walk(startDirectory, results);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return results;
  }
  
  protected void handleFile(File file, int depth, Collection<File> results) {
    if (file.getName().matches(".*" + name + "$")) {
      FileUtils.replaceInFile(file, regexFind);
      results.add(file);
      System.out.println("Regexed file" + file.toString());
    }
  }
  
}
