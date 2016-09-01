package com.lakhi.file.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/file")
public class fileResource {

	@POST
	@Consumes({MediaType.MULTIPART_FORM_DATA,MediaType.APPLICATION_JSON})
	@Produces({MediaType.MULTIPART_FORM_DATA,MediaType.APPLICATION_JSON})
	public String uploadFile(@FormDataParam("file") InputStream is,
			@FormDataParam("file") FormDataContentDisposition fileDetail, @FormDataParam("name") String name) {
				
		String fileLocation = "/home/matrixm/" + fileDetail.getFileName();
						
		try {

			FileOutputStream out = new FileOutputStream(new File(fileLocation));
			int read = 0;
			byte bytes[] = new byte[1024];
			out = new FileOutputStream(new File(fileLocation));
			while ((read = is.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "File successfully uploaded to : " + fileLocation + "\n Name = " + name;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String getText() {
		return "Hello World !";
	}

}
