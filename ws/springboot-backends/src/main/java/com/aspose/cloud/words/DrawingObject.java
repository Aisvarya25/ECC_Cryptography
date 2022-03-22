package com.aspose.cloud.words;
import java.util.List;

    public class DrawingObject
    {

        public DrawingObject() { }

        private LinkResponse _link;
        public LinkResponse getlink(){return _link;}
        public void setlink(LinkResponse link){_link=link;}

        private float _Height;
        public float getHeight(){return _Height;}
        public void setHeight(float Height){_Height=Height;}

        private LinkResponse _ImageDataLink;
        public LinkResponse getImageDataLink(){return _ImageDataLink;}
        public void setImageDataLink(LinkResponse ImageDataLink){_ImageDataLink=ImageDataLink;}

        private LinkResponse _OleDataLink;
        public LinkResponse getOleDataLink(){return _OleDataLink;}
        public void setOleDataLink(LinkResponse OleDataLink){_OleDataLink=OleDataLink;}

        private List<LinkResponse> _RenderLinks;
        public List<LinkResponse> getRenderLinks(){return _RenderLinks;}
        public void setRenderLinks(List<LinkResponse> RenderLinks){_RenderLinks=RenderLinks;}

        private float _Width;
        public float getWidth(){return _Width;}
        public void setWidth(float Width){_Width=Width;}


    }