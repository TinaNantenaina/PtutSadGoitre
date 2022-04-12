
package SADGoitre.service;

import SADGoitre.dao.DiagnosticRepository;
import SADGoitre.entity.Diagnostic;
import SADGoitre.entity.Valeur_examen;
import java.util.List;
import javax.transaction.Transactional;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Tina
 */
@Service
public class DroolAccessService {
    @Autowired
    private DiagnosticRepository daoDiagnostic;
    
    public List<Valeur_examen> recupererValeurExamen(int patientId) {
        return null;
        //retourner la liste des Valeur_examen  associÃ© Ã  un patient
    }

    public void insererDiagnostic (Diagnostic nouveauDiagnostic) {
        //utiliser diagnostic respository pour inserer le nouveau diagnostic dans la base de donnÃ©es
           
    }
}
