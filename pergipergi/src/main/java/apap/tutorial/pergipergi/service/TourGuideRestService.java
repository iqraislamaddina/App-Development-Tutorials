package apap.tutorial.pergipergi.service;

import reactor.core.publisher.Mono;

public interface TourGuideRestService {
    Mono<String> getAge(String namaGuide);
}