package cn.id0755.im.server.biz;

public interface IRequestListener<Response> {
    void onSuccess(Response response);
}
