package br.com.sgm.geo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*")
public class GeoreferencedController {


//    @GetMapping(value = "/city-data")
    @RequestMapping(value = "/city-data", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createAuthenticationToken() throws Exception {

        return ResponseEntity.ok("OK");
    }
}
