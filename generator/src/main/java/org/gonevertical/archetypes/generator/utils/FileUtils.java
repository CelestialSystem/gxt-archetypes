package org.gonevertical.archetypes.generator.utils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

  public static void replaceInFileByLine(File file, String regexFind, String regexReplace) {
    if (file == null) {
      return;
    }
    String tmpName = file.getAbsolutePath() + ".tmp";
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    BufferedReader br = null;
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      br = new BufferedReader(new InputStreamReader(dis));
      FileWriter fstream = new FileWriter(tmpName);
      BufferedWriter out = new BufferedWriter(fstream);
      String s = null;
      while ((s = br.readLine()) != null) {
        s = s.replaceAll(regexFind, regexReplace);
        out.write(s + "\n");
      }
      out.close();
      fstream.close();
      br.close();
      fis.close();
      bis.close();
      dis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    File rf = new File(tmpName);
    rf.renameTo(file);
  }
  
  /**
   * This replaces the regexFind once.   
   * 
   * @param file
   * @param regexFind
   * @param replaceWithString
   */
  public static void replaceInFileByLineOnce(File file, String regexFind, String replaceWithString) {
    if (file == null) {
      return;
    }
    String tmpName = file.getAbsolutePath() + ".tmp";
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    BufferedReader br = null;
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      br = new BufferedReader(new InputStreamReader(dis));
      FileWriter fstream = new FileWriter(tmpName);
      BufferedWriter out = new BufferedWriter(fstream);
      String s = null;
      while ((s = br.readLine()) != null) {
        s = s.replace(regexFind, replaceWithString);
        out.write(s + "\n");
      }
      out.close();
      fstream.close();
      br.close();
      fis.close();
      bis.close();
      dis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    File rf = new File(tmpName);
    rf.renameTo(file);
  }

  public static void replaceInFile(File file, String regexFind) {
    if (file == null) {
      return;
    }

    String fileText = null;
    try {
      fileText = org.apache.commons.io.FileUtils.readFileToString(file);
    } catch (IOException e1) {
      e1.printStackTrace();
      return;
    }

    Pattern regex = Pattern.compile(regexFind, Pattern.DOTALL);
    Matcher regexMatcher = regex.matcher(fileText);
    String found = "";
    if (regexMatcher.find()) {
      found = regexMatcher.group(1);
      if (found != null && found.length() > 0) {
        fileText = fileText.replace(found, "");
      }
    }

    try {
      org.apache.commons.io.FileUtils.write(file, fileText);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean deleteRecursive(File path) {
    if (path.exists()) {
      File[] files = path.listFiles();
      for (File file : files) {
        if (file.isDirectory()) {
          deleteRecursive(file);
        } else {
          boolean deleted = file.delete();
          System.out.println("deleted=" + deleted);
        }
      }
    }
    return (path.delete());
  }

  public static String findInFileAndReturnLine(File file, String regex) {
    if (file == null) {
      return null;
    }
    String line = null;
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    BufferedReader br = null;
    boolean found = false;
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      br = new BufferedReader(new InputStreamReader(dis));
      String s = null;
      while ((s = br.readLine()) != null) {
        found = StringUtils.findMatch(regex, s);
        if (found == true) {
          line = s;
          break;
        }
      }
      br.close();
      fis.close();
      bis.close();
      dis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return line;
  }
  
  public static boolean findInFile(File file, String regex) {
    if (file == null) {
      return false;
    }
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    BufferedReader br = null;
    boolean found = false;
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      br = new BufferedReader(new InputStreamReader(dis));
      String s = null;
      while ((s = br.readLine()) != null) {
        found = StringUtils.findMatch(regex, s);
        if (found == true) {
          break;
        }
      }
      br.close();
      fis.close();
      bis.close();
      dis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return found;
  }

  public static String fileToString(File file) {
    if (file == null) {
      return null;
    }
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
    BufferedReader br = null;
    String ss = "";
    try {
      fis = new FileInputStream(file);
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      br = new BufferedReader(new InputStreamReader(dis));
      String s = null;
      while ((s = br.readLine()) != null) {
        ss += s;
      }
      br.close();
      fis.close();
      bis.close();
      dis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ss;
  }

}