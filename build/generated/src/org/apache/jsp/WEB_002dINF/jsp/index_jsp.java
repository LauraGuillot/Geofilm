package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Geofilm</title>\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"Ressources/logo2.png\" >\r\n");
      out.write("\r\n");
      out.write("        <!-- BOOTSTRAP -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- LEAFLET LIBRARY -->\r\n");
      out.write("        <script src=\"leaflet/leaflet-src.js\"></script>\r\n");
      out.write("        <script src=\"leaflet/leaflet.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"leaflet/leaflet.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- CHAINES DE CARACTERES -->\r\n");
      out.write("        <script src=\"Scripts/language.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/strings.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- STYLES -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/navigation.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/home.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/button.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/modal_error.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/modal_form.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"Stylesheets/font.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- MAP -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.0.3/dist/leaflet.css\" />\r\n");
      out.write("        <script src=\"https://unpkg.com/leaflet@1.0.3/dist/leaflet.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/position_tracker.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/load_map.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- SCRIPTS -->\r\n");
      out.write("        <script src=\"Scripts/home.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/connect.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/inscription.js\"></script>\r\n");
      out.write("        <script src=\"Scripts/password_forgotten.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body onload=\"load();\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Chargement des markers en caché -->\r\n");
      out.write("        <input type=\"hidden\" id=\"nbMarkers\" value=\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\"/> \r\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- NAVIGATION -->\r\n");
      out.write("    <nav class=\"navbar-default navbar \" role=\"navigation\">\r\n");
      out.write("        <div class=\"navbar-collapse collapse\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <li class=\"navbar-left\" ><a href=\"#\" id=\"logo\"><img src=\"Ressources/logo1.png\" width=\"100px\" ></a></li> <!-- LOGO-->\r\n");
      out.write("                <li class=\"navbar-right\"><a href=\"#\"><img id=\"connection\" src=\"Ressources/connection.png\" onMouseOver=\"this.src = 'Ressources/connection_over.png'\" onMouseOut=\"this.src = 'Ressources/connection.png'\" width=\"25px\" onclick=\"pop_connexion()\"></a></li><!-- Connexion-->\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <!-- CONTENU PRINCIPAL -->\r\n");
      out.write("    <div class=\"container\">    \r\n");
      out.write("        <div  class=\"row content\">          \r\n");
      out.write("            <!-- Volet de gauche -->\r\n");
      out.write("            <div id=\"left_div\" class=\"col-md-4\">\r\n");
      out.write("                <p id=\"welcome\"> </p>\r\n");
      out.write("                <p id=\"title\"> Geofilm </p>\r\n");
      out.write("                <br><br><br>\r\n");
      out.write("                <p class=\"description\" id=\"description\"> </p>\r\n");
      out.write("                <p class=\"description\" id=\"description2\"> </p>\r\n");
      out.write("                <br><br><br><br>\r\n");
      out.write("                <center> <button href=\"#\" class=\"button large_button\" id=\"connexion\" onclick=\"pop_connexion()\"></button></center>\r\n");
      out.write("                <br><br><br><br>\r\n");
      out.write("                <p id=\"info_gps\" class=\"info\"> </p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Map -->\r\n");
      out.write("            <div id=\"mapid\" class=\"col-md-8\"> </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!--POPUP : boîte de connexion-->\r\n");
      out.write("    <div class=\"modal fade\" id=\"connection_form\" role=\"dialog\">\r\n");
      out.write("        <div class=\"modal-dialog modal-sm\">\r\n");
      out.write("            <div class=\"modal-content modal_form\">\r\n");
      out.write("\r\n");
      out.write("                <button class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                \r\n");
      out.write("                <p id=\"connexion2\" class= \"title\"  style=\"margin-top: 40px\"</p> \r\n");
      out.write("                <p id=\"error_connect\" class=\"error_message\"></p>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"modal-body\">         \r\n");
      out.write("                    <p class=\"label_form\" id=\"connection_id\"></p>\r\n");
      out.write("                    <input type=\"text\" name =\"email\" id=\"email\">               \r\n");
      out.write("                    <p  class=\"label_form\" id=\"connection_password\"></p>\r\n");
      out.write("                    <input  type=\"password\" name=\"password\" id=\"password\"  style=\"margin-bottom:7px\">\r\n");
      out.write("                    <p class=\"label_form_small\" id=\"mandatory\"></p>\r\n");
      out.write("\r\n");
      out.write("                    <center><div class=\"info_link\" style=\"margin-bottom: 20px\">\r\n");
      out.write("                        <div class=\"info_link\" id=\"password_forgotten\"></div>\r\n");
      out.write("                        <a id=\"click_here\" class=\"click_here\" href=\"#\" onclick=\"pop_obtain_password()\"></a>\r\n");
      out.write("                        <div class=\"info_link\">.</div>\r\n");
      out.write("                        </div></center>\r\n");
      out.write("\r\n");
      out.write("                    <center><button id =\"valid_connexion\" type=\"button\" class=\"button small_button\" onclick=\"connect()\" style=\"margin-bottom: 40px\"></button></center>\r\n");
      out.write("\r\n");
      out.write("                    <center><div class=\"info_link\">\r\n");
      out.write("                        <div class=\"info_link\" id=\"membership\"></div>\r\n");
      out.write("                        <a id=\"click_here2\" class=\"click_here\" href=\"#\" onclick=\"pop_inscription();\"></a>\r\n");
      out.write("                         <div class=\"info_link\" id=\"membership2\"></div>\r\n");
      out.write("                        </div><center>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <!--POPUP : inscription-->\r\n");
      out.write("    <div class=\"modal fade\" id=\"inscription_form\" role=\"dialog\">\r\n");
      out.write("        <div class=\"modal-dialog modal-sm\">\r\n");
      out.write("            <div class=\"modal-content modal_form\">\r\n");
      out.write("\r\n");
      out.write("                <button class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                \r\n");
      out.write("                <p id=\"inscription\" class= \"title\"  style=\"margin-top: 40px\"</p> \r\n");
      out.write("                <p id=\"inscription_error\" class=\"error_message\"></p>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"modal-body\">  \r\n");
      out.write("                     <p  class=\"label_form\" id=\"inscription_name_label\"></p>\r\n");
      out.write("                    <input  type=\"text\" name=\"name\" id=\"inscription_name\">\r\n");
      out.write("                     <p  class=\"label_form\" id=\"inscription_firstname_label\"></p>\r\n");
      out.write("                    <input  type=\"text\" name=\"firstname\" id=\"inscription_firstname\">\r\n");
      out.write("                    <p class=\"label_form\" id=\"inscription_email_label\"></p>\r\n");
      out.write("                    <input type=\"text\" name =\"email\" id=\"inscription_email\">               \r\n");
      out.write("                    <p  class=\"label_form\" id=\"inscription_password_label\"></p>\r\n");
      out.write("                    <input  type=\"password\" name=\"password\" id=\"inscription_password\">\r\n");
      out.write("                    <p  class=\"label_form\" id=\"inscription_password2_label\"></p>\r\n");
      out.write("                    <input  type=\"password\" name=\"password\" id=\"inscription_password2\" style=\"margin-bottom:7px\">\r\n");
      out.write("                    <p class=\"label_form_small\" id=\"mandatory2\"></p>\r\n");
      out.write("\r\n");
      out.write("                    <center><button id =\"valid_inscription\" type=\"button\" class=\"button small_button\" onclick=\"inscription()\" style=\"margin-top: 20px\"></button></center>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!--POPUP : password forgotten-->\r\n");
      out.write("    <div class=\"modal fade\" id=\"password_forgotten_form\" role=\"dialog\">\r\n");
      out.write("        <div class=\"modal-dialog modal-sm\">\r\n");
      out.write("            <div class=\"modal-content modal_form\">\r\n");
      out.write("\r\n");
      out.write("                <button class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                \r\n");
      out.write("                <p id=\"password_title\" class= \"title\"  style=\"margin-top: 40px\"</p> \r\n");
      out.write("                <p id=\"password_forgotten_error\" class=\"error_message\"></p>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"modal-body\">  \r\n");
      out.write("                     <p  class=\"label_form\" id=\"password_forgotten_email_label\"></p>\r\n");
      out.write("                    <input  type=\"text\" name=\"email\" id=\"password_forgotten_email\">\r\n");
      out.write("                    \r\n");
      out.write("                    <p class=\"label_form_small\" id=\"mandatory3\"></p>\r\n");
      out.write("\r\n");
      out.write("                    <center><button id =\"valid_password_forgotten\" type=\"button\" class=\"button small_button\" onclick=\"obtain_password()\" style=\"margin-top: 20px\"></button></center>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!-- POPUP : message d'erreur si pas de gps -->\r\n");
      out.write("    <div class=\"modal fade\" id=\"gps_error_modal\" role=\"dialog\">\r\n");
      out.write("        <div class=\"modal-dialog modal-sm\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-body\">\r\n");
      out.write("                    <p id=\"error_gps\"></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <center>  <button id =\"close_error_gps\" type=\"button\" class=\"button small_button\" data-dismiss=\"modal\"></button></center>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(markers)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("p");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${markers}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            <input type=\"hidden\" id=\"p");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\" value=\"");
          if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\"/>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status.index}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p['locationThegeom']}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }
}
