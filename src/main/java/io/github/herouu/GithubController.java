package io.github.herouu;

import io.github.herouu.feign.Contributor;
import io.github.herouu.feign.GithubFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jufab
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/github")
@Slf4j
public class GithubController {

  final GithubFeign githubFeign;

  public GithubController(GithubFeign githubFeign) {
    this.githubFeign = githubFeign;
  }

  /**
   * http://localhost:8080/github/contributors?owner=open-telemetry&repository=opentelemetry-js
   *
   * @param owner      owner
   * @param repository repository
   * @return List
   */
  @GetMapping(value = "/contributors", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Contributor> getContributors(@RequestParam String owner,
                                           @RequestParam String repository) {
    log.info("owner:{},repository:{}", owner, repository);
    return this.githubFeign.contributors(owner, repository);
  }
}
