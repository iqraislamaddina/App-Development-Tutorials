package apap.tutorial.pergipergi.service;
 
import java.util.List;
 
 
import apap.tutorial.pergipergi.model.TravelAgensiModel;
 
public interface TravelAgensiService {
   //Method untuk menambahkan agensi
   void addAgensi(TravelAgensiModel travelAgensi);
 
   //Method untuk mendapatkan daftar agensi yang telah tersimpan
   List<TravelAgensiModel> getListAgensi();
 
   //Method untuk mendapatkan data agensi berdasarkan id agensi
   TravelAgensiModel getAgensiBynoAgensi(Long noAgensi);
 
   TravelAgensiModel updateAgensi(TravelAgensiModel travelAgensi);

   void deleteAgensiBynoAgensi(Long noAgensi);

}