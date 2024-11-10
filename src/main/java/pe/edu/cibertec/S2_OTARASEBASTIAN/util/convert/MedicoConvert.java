package pe.edu.cibertec.S2_OTARASEBASTIAN.util.convert;


import org.springframework.stereotype.Component;
import pe.edu.cibertec.S2_OTARASEBASTIAN.model.bd.Medico;
import pe.edu.cibertec.ws.objects.Medicosoap;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicoConvert {

    public Medico convertMedicoBD(Medicosoap medicosoap){
        Medico medico = new Medico();
        medico.setIdmedico(medicosoap.getId());
        medico.setNommedico(medicosoap.getNombre());
        medico.setApemedico(medicosoap.getApellido());
        medico.setFechnacmedico(medicosoap.getFecha());
        return  medico;
    }

    public Medicosoap convertMedicoSoap(Medico medico){
        Medicosoap medicosoap = new Medicosoap();
        medicosoap.setId(medico.getIdmedico());
        medicosoap.setNombre(medico.getNommedico());
        medicosoap.setApellido(medico.getApemedico());
        medicosoap.setFecha(medico.getFechnacmedico());
        return medicosoap;
    }

    public List<Medico> convertListMedicoBd(List<Medicosoap> medicosoap){
        List<Medico> medicos = new ArrayList<Medico>();
        for(Medicosoap medico : medicosoap){
            medicos.add(convertMedicoBD(medico));
        }
        return medicos;
    }


    public List<Medicosoap> convertListMedicoSoap(List<Medico> medico){
        List<Medicosoap> medicosoap = new ArrayList<Medicosoap>();
        for(Medico medico1 : medico){
            medicosoap.add(convertMedicoSoap(medico1));
        }
        return medicosoap;
    }
}
