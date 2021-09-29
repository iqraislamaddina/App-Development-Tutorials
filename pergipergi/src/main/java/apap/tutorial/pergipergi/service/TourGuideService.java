package apap.tutorial.pergipergi.service;
import apap.tutorial.pergipergi.model.TourGuideModel;

public interface TourGuideService {
    void addTourGuide(TourGuideModel tourGuide);
    TourGuideModel getTourGuideBynoTourGuide(Long noTourGuide);
    TourGuideModel updateTourGuide(TourGuideModel tourGuide);
    void deleteTourGuideByNoTourGuide(Long noTourGuide);
}