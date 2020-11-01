package com.rickmorty.service.loader;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataLoadService {
    private static final Logger logger = LoggerFactory.getLogger(DataLoadService.class);
    private final LocationLoadService locationLoadService;
    private final EpisodeLoadService episodeLoadService;
    private final CharacterLoadService characterLoadService;

    @Autowired
    public DataLoadService(LocationLoadService locationLoadService,
                           EpisodeLoadService episodeLoadService,
                           CharacterLoadService characterLoadService) {
        this.locationLoadService = locationLoadService;
        this.episodeLoadService = episodeLoadService;
        this.characterLoadService = characterLoadService;
    }

    @Scheduled(cron = "${loading.cron.time}")
    public void loadDataFromApi() {
        locationLoadService.loadLocations();
        episodeLoadService.loadEpisodes();
        characterLoadService.loadCharacters();
        logger.info("Data loaded to DB");
    }

    @PostConstruct
    public void init() {
        loadDataFromApi();
    }
}
