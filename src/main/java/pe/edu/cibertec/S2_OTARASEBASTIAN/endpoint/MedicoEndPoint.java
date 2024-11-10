package pe.edu.cibertec.S2_OTARASEBASTIAN.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.S2_OTARASEBASTIAN.service.IMedicoService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class MedicoEndPoint {


    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";
    @Autowired
    private IMedicoService medicoService;

    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "getListMedicoRequest")
    @ResponsePayload
    public GetListMedicoResponse getListDomicilios(@RequestPayload
                                                       GetListMedicoRequest request) {
        return medicoService.listaMedicos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "getMedicoRequest")
    @ResponsePayload
    public GetMedicoResponse getMedico(@RequestPayload
                                       GetMedicoRequest request) {
        return medicoService.getMedico(request.getId());
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMedicoSaveRequest")
    @ResponsePayload
    public PostMedicoResponse guardarDomicilio(@RequestPayload PostMedicoRequest request) {
        return medicoService.postMedicoSave(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMedicoUpdateRequest")
    @ResponsePayload
    public PostMedicoResponse actualizarDomicilio(@RequestPayload PostMedicoRequest request) {
        return medicoService.postMedicoUpdate(request);
    }

}
