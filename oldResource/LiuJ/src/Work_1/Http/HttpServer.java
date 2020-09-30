//package Work.Http;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.http.*;
//
//import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
//import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
//import static io.netty.handler.codec.http.HttpResponseStatus.OK;
//import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
//import static org.jboss.netty.handler.codec.rtsp.RtspHeaders.Names.CONTENT_TYPE;
//
//public class HttpServer {
//    public void bind(int port) throws Exception {
//
//        //EventLoopGroup是一个线程组，它包含了一组nio线程，专门用于网络事件的处理，实际上他们就是Reactor线程组
//        //这里创建2个的原因是一个用于服务端接受客户的连接，另一个用于SockentChannel的网络读写
//        EventLoopGroup bGroup = new NioEventLoopGroup();
//        EventLoopGroup cGroup = new NioEventLoopGroup();
//
//        try {
//            //对服务端做配置和启动的类
//            ServerBootstrap b = new ServerBootstrap();
//
//            //bGroup(parentGroup)一般用来接收accpt请求，cGroup(childGroup)用来处理各个连接的请求
//            b.group(bGroup, cGroup)
//
//                    //channel()方法设置了ServerBootstrap的ChannelFactory，
//                    //传入的参数是NioServerSocketChannel.class(ReflectiveChannelFactory创建的是NioServerSocketChannel的实例)
//                    .channel(NioServerSocketChannel.class)
//
//                    //设置Socket连接的参数
//                    .option(ChannelOption.SO_BACKLOG, 1024)
//
//                    //设置childGroup的Handler,childHandler()传入的ChannelInitializer实现了一个initChannel方法
//                    // 用于初始化Channel的pipeline，以处理请求内容
//                    .childHandler(new HttpChannelInitService()).option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            //bind()的调用最终调用到了doBind(final SocketAddress)
//            ChannelFuture f = b.bind(port).sync();
//            f.channel().closeFuture().sync();
//        } finally {
//            bGroup.shutdownGracefully();
//            cGroup.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        int port = 8080;
//        if (args != null && args.length > 0) {
//            try {
//                port = Integer.valueOf(args[0]);
//            } catch (NumberFormatException e) {
//
//            }
//        }
//        new HttpServer().bind(port);
//    }
//}
//
//
////class HttpServerHandler extends ChannelInboundHandlerAdapter {
//////    private ByteBufToBytes reader;
////    @Override
////    public void channelRead(ChannelHandlerContext ctx, Object msg)
////            throws Exception {
////        FullHttpResponse response = new DefaultFullHttpResponse(
////                HTTP_1_1, OK, Unpooled.wrappedBuffer("OK OK OK OK"
////                .getBytes()));
////        response.headers().set(CONTENT_TYPE, "text/plain");
////        response.headers().setInt(CONTENT_LENGTH,
////                response.content().readableBytes());
////        response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
////        ctx.write(response);
////        ctx.flush();
////    }
////    @Override
////    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
////        ctx.flush();
////    }
////    @Override
////    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
////            throws Exception {
////        ctx.close();
////    }
////}
//
//class HttpChannelInitService<SocketChannel extends Channel> extends ChannelInitializer<SocketChannel> {
//    @Override
//    protected void initChannel(SocketChannel sc)
//            throws Exception {
//        sc.pipeline().addLast(new HttpResponseEncoder());
//
//        sc.pipeline().addLast(new HttpRequestDecoder());
//
////        sc.pipeline().addLast(new HttpChannelHandler());
//    }
//}
