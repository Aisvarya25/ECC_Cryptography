package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Validations resource
    /// </summary>
    public class ValidationsResponse extends com.aspose.cloud.common.BaseResponse
    {       
        private LinkResponse link;
        private int Count;            
        private List<LinkResponse> ValidationList;
        private Validation Validation;
        
        public LinkResponse getLink(){return link;}
        public int getCount(){return Count;}            
        public List<LinkResponse> getValidationList(){return ValidationList;}
        public Validation getValidation(){return Validation;};

    }