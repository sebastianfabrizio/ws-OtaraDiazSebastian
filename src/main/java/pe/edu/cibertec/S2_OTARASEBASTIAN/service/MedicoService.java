package pe.edu.cibertec.S2_OTARASEBASTIAN.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.S2_OTARASEBASTIAN.model.bd.Medico;
import pe.edu.cibertec.S2_OTARASEBASTIAN.repository.MedicoRepository;
import pe.edu.cibertec.S2_OTARASEBASTIAN.util.convert.MedicoConvert;
import pe.edu.cibertec.ws.objects.GetListMedicoResponse;
import pe.edu.cibertec.ws.objects.GetMedicoResponse;
import pe.edu.cibertec.ws.objects.PostMedicoRequest;
import pe.edu.cibertec.ws.objects.PostMedicoResponse;

@Service
@RequiredArgsConstructor
public class MedicoService implements IMedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoConvert medicoConvert;

    @Override
    public GetListMedicoResponse listaMedicos() {
        GetListMedicoResponse response = new GetListMedicoResponse();
        response.getListmedicos().addAll(
                medicoConvert.convertListMedicoSoap(
                        medicoRepository.findAll()
                )
        );
        return response;
    }

    @Override
    public GetMedicoResponse getMedico(int id) {
        GetMedicoResponse response= new GetMedicoResponse();
        Medico medico = medicoRepository.findById(id).orElse(null);
        if (medico != null) {
            response.setDomicilio(medicoConvert.convertMedicoSoap(medico));
        }
        return response;
    }

    @Override
    public PostMedicoResponse postMedicoSave(PostMedicoRequest medico) {
        PostMedicoResponse response = new PostMedicoResponse();
        Medico nuevoMedico = medicoRepository.save(
                medicoConvert.convertMedicoBD(medico.getDomicilio())
        );
        response.setDomicilio(
                medicoConvert.convertMedicoSoap(nuevoMedico));
        return response;
    }

    @Override
    public PostMedicoResponse postMedicoUpdate(PostMedicoRequest medico) {
        PostMedicoResponse response = new PostMedicoResponse();
        Medico medicoExistente = medicoRepository.findById(medico.getDomicilio().getId()).orElse(null);

        if (medicoExistente == null) {
            response.setDomicilio(null);
            return response;
        }

        Medico medicoActualizado = medicoConvert.convertMedicoBD(medico.getDomicilio());
        medicoActualizado.setIdmedico(medicoExistente.getIdmedico());
        medicoRepository.save(medicoActualizado);
        response.setDomicilio(medicoConvert.convertMedicoSoap(medicoActualizado));
        return response;
    }


}
