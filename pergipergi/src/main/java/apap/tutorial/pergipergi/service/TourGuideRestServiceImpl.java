package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional

public class TourGuideRestServiceImpl implements TourGuideRestService{
    private final WebClient webClient;
    public TourGuideRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.guideUrl).build();
    }

    @Override
    public Mono<String> getAge(String namaGuide){
        return this.webClient.get().uri("?name="+ namaGuide)
                .retrieve()
                .bodyToMono(String.class);
    }

}