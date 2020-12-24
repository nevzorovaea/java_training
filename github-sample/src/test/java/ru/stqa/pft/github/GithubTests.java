package ru.stqa.pft.github;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommit() throws IOException {
    Github github = new RtGithub("771d855b8bb2e10ceaeda2933259235b23fea63c");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("nevzorovaea", "java_training")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableBiMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
