package com.example.demo.endpoint.rest.controller.health.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {
  private static final String FILE_PATH = "/tmp/stored-int.txt";

  @GetMapping("/stored-int")
  public String getStoredInt() throws IOException {
    File file = new File(FILE_PATH);

    if (!file.exists()) {
      int random = new Random().nextInt(1_000_000);
      FileWriter writer = new FileWriter(file);
      writer.write(String.valueOf(random));
      writer.close();
      return String.valueOf(random);
    } else {
      return Files.readString(file.toPath());
    }
  }
}
