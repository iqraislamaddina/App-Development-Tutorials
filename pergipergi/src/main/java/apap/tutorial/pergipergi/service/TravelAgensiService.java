package apap.tutorial.pergipergi.service;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import java.util.List;

public interface TravelAgensiService {
//Method untuk menambahkan agensi
void addAgensi(TravelAgensiModel travelAgensi);
//Method untuk mendapatkan daftar agensi yang telah tersimpan
List<TravelAgensiModel> getListAgensi();
//Method untuk mendapatkan data agensi berdasarkan id agensi
TravelAgensiModel getAgensiByidAgensi(String idAgensi);
// Method untuk menghapus agensi
void deleteAgensi(TravelAgensiModel travelAgensi);
}

