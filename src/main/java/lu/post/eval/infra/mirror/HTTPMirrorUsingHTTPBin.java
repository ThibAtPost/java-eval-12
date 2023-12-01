package lu.post.eval.infra.mirror;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.model.HeadersBO;
import lu.post.eval.domain.service.IHTTMirrorClient;
import lu.post.eval.domain.transformers.ToHeadersBO;
import lu.post.gen.v6.httpbin.HttpMethodsApi;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HTTPMirrorUsingHTTPBin implements IHTTMirrorClient {

    private final HttpMethodsApi httpMethodsApi;
    private final RequestInspectionApi requestInspectionApi;

    @Override
    public List<HeadersBO> mirrorMyGetHeaders() {
        return httpMethodsApi.getGet().toFuture()
                .thenApply(getResponse -> ToHeadersBO.of(getResponse.getHeaders())).join();
    }

    @Override
    public String getMyIp() {
        return requestInspectionApi.ipGet().toFuture().thenApply(ipResponse -> ipResponse.getOrigin()).join();
    }
}
