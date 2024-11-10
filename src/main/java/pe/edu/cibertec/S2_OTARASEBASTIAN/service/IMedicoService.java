package pe.edu.cibertec.S2_OTARASEBASTIAN.service;


import pe.edu.cibertec.ws.objects.GetListMedicoResponse;
import pe.edu.cibertec.ws.objects.GetMedicoResponse;
import pe.edu.cibertec.ws.objects.PostMedicoRequest;
import pe.edu.cibertec.ws.objects.PostMedicoResponse;

public interface IMedicoService {

    GetListMedicoResponse listaMedicos();
    GetMedicoResponse getMedico(int id);
    PostMedicoResponse postMedicoSave(PostMedicoRequest medico);
    PostMedicoResponse postMedicoUpdate(PostMedicoRequest medico);
}
