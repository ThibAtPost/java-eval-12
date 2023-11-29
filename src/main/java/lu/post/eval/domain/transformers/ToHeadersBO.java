package lu.post.eval.domain.transformers;

import lu.post.eval.domain.model.HeaderName;
import lu.post.eval.domain.model.HeaderValue;
import lu.post.eval.domain.model.HeadersBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToHeadersBO {
    public static List<HeadersBO> of(Map<String, Object> headers) {
        if (headers != null) {
            return headers.entrySet().stream().map(stringObjectEntry -> new HeadersBO(
                    HeaderName.of(stringObjectEntry.getKey()),
                    HeaderValue.of((String) stringObjectEntry.getValue())
            )).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
