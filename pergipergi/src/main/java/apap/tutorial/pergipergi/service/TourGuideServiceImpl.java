package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TourGuideServiceImpl implements TourGuideService{

    @Autowired
    TourGuideDb tourGuideDb;
    
    @Override
    public void addTourGuide(TourGuideModel tourGuide){ tourGuideDb.save(tourGuide); }

    @Override
    public TourGuideModel getTourGuideBynoTourGuide(Long noTourGuide) {
        Optional<TourGuideModel> tourGuide = tourGuideDb.findByNoTourGuide(noTourGuide);
        if (tourGuide.isPresent())
            return tourGuide.get();
        else
            return null;
    }
    
    @Override
    public TourGuideModel updateTourGuide(TourGuideModel tourGuide) {
        tourGuideDb.save(tourGuide);
        return tourGuide;
    }

    @Override
    public void deleteTourGuideByNoTourGuide(Long noTourGuide){
        Optional<TourGuideModel> tourGuide = tourGuideDb.findByNoTourGuide(noTourGuide);
        if (tourGuide.isPresent()){
            TourGuideModel tourGuideModel = tourGuide.get();
            tourGuideDb.delete(tourGuideModel);
        }
            
    }


}