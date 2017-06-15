package com.pet.controllers;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.websocket.server.PathParam;

import org.h2.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.Pet;
import com.pet.services.PetService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pet/")
@Api(value="pet", description="Operations about pet")
public class PetRestController {

	private PetService petService;

	@Autowired
	public void setPetService(PetService petService) {
		this.petService = petService;
	}


	@ApiOperation(value = "Get pet by ID",response = Pet.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid Id supplied"),
			@ApiResponse(code = 404, message = "Pet not found"),
	})
	@RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
	public Pet getPetById(@PathVariable Integer id){
		return petService.getPetById(id);
	}

	@ApiOperation(value = "Finds Pets by status", notes = "Multiple status values can be provided with comma separated strings", response = Pet.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid Id supplied"),
			@ApiResponse(code = 404, message = "Pet not found"),
	})
	@RequestMapping(value = "/findByStatus", method= RequestMethod.GET, produces = "application/json")
	public List<Pet> findPetByStatus(@ApiParam(value = "Status values that need to be considered for filter", required = true, defaultValue = "available", 
	allowableValues = "available,pending,sold", allowMultiple = true) @PathVariable("status") String status){
		return petService.findPetByStatus(status);
	}

	@ApiOperation(value = "Add a new pet to the store")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity savePet( @ApiParam(value = "Pet object that needs to be added to the store", required = true)Pet pet){
		petService.savePet(pet);
		return new ResponseEntity("successful operation", HttpStatus.OK);
	}
	

    @ApiOperation(value = "Update an existing pet")
    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updatePet( @ApiParam(value = "Pet object that needs to be added to the store", required = true)  Pet newPet){
    	Pet pet = petService.getPetById(newPet.getId());
    	pet.setCategory(newPet.getCategory());
    	pet.setName(newPet.getName());
    	pet.setStatus(newPet.getStatus());
    	petService.savePet(pet);
        return new ResponseEntity("successful operation", HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a pet")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid username supplied"),
			@ApiResponse(code = 404, message = "Pet not found"),
	})
    @RequestMapping(value="/{petId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@ApiParam(value = "Pet to delete", required = true)@PathParam("petId") Integer petId){
    	petService.deletePet(petId);
        return new ResponseEntity("successful operation", HttpStatus.OK);

    }
    
    @ApiOperation(value = "uploads an image")
    @RequestMapping(value="/{petId}/uploadImage", method = RequestMethod.POST,consumes="multipart/form-data", produces = "application/json")
    public ResponseEntity uploadFile(
      @ApiParam(value = "ID of pet to update", required = true) @PathParam("petId") Long petId,
      @ApiParam(value = "Additional data to pass to server") @FormDataParam("additionalMetadata") String metaData,
      @ApiParam(value = "file to upload") @FormDataParam("file") InputStream inputStream,
      @ApiParam(value = "file detail") @FormDataParam("file") FormDataContentDisposition fileDetail) {
      try {
        String uploadedFileLocation = "./" + fileDetail.getFileName();
        IOUtils.copy(inputStream, new FileOutputStream(uploadedFileLocation));
        
        return new ResponseEntity("successful operation", HttpStatus.OK);
      }
      catch (Exception e) {
    	  return new ResponseEntity("Upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


}
