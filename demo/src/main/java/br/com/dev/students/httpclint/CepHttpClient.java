// package br.com.dev.students.httpclint;

// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// import br.com.dev.students.entity.Endereco;

// @FeignClient(value = "cep-client", url = "http://brasilapi.com.br/api")
// public interface CepHttpClient {

//    // @RequestMapping(method = RequestMethod.GET)
//      @GetMapping("/cep/v2/{cep}")
//     public Endereco obterEnderecoPeloCep(@PathVariable("cep") String cep);

// }