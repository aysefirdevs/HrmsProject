package kodlamaio.HrmsProject.core.utilities.adapters.concretes;

//import java.rmi.RemoteException;


import org.springframework.stereotype.Service;

import kodlamaio.HrmsProject.core.utilities.adapters.abstracts.CheckIfRealPersonService;
import kodlamaio.HrmsProject.entities.concretes.Candidate;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements CheckIfRealPersonService {

	@Override
	public boolean checkIfReal(Candidate candidate) {
		if(candidate.getIdentificationNumber().length()!=11) {
			return false;

		}
		return true;
	}
	
	
	

/*	@Override
	public boolean checkIfReal(Candidate candidate) {
		KPSPublicSoapProxy client= new KPSPublicSoapProxy();
		
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentificationNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), 
					candidate.getBirthDate());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
		
	}
*/
	
}
