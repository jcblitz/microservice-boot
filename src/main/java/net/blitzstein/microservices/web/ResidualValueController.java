package net.blitzstein.microservices.web;

import io.swagger.annotations.*;
import net.blitzstein.microservices.domain.Asset;
import net.blitzstein.microservices.domain.ResidualCalculation;
import net.blitzstein.microservices.service.ResidualValueCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jared on 1/26/17.
 */
@RestController
public class ResidualValueController {

    @Autowired
    private ResidualValueCalculator residualValueCalculator;

    private static Asset ASSET = new Asset("Big Printer", "This is a giant printer", 10000, 8000, "CHINA");


    @RequestMapping(value = "/value/asset", method = RequestMethod.GET )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "leaseTerm", value = "The number of months an asset is leased for", required = true, dataType = "int", paramType = "query")
    })

    @ApiOperation(value = "Calculates the residual value for an asset with a given lease term")
    public ResidualCalculation value(@RequestParam("leaseTerm") int leaseTerm) {
        String JSONTemplate = "{ \"residualValue\" : \"%s\" }";
        long residualValue = residualValueCalculator.forAsset(ASSET, leaseTerm);
        ResidualCalculation residualCalculation = new ResidualCalculation(ASSET, residualValue);
        return residualCalculation;
    }
}
