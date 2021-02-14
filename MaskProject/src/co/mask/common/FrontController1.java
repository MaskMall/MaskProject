package co.mask.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.admin.web.AdminFrom;
import co.mask.admin.web.AdminSellerForm;
import co.mask.admin.web.AdminUserForm;
import co.mask.admin.web.SellerDelete;
import co.mask.admin.web.SellerUpForm;
import co.mask.admin.web.SellerUpdate;
import co.mask.admin.web.UserDelete;
import co.mask.admin.web.UserUpForm;
import co.mask.admin.web.UserUpdate;
import co.mask.board.web.BoardDelete;
import co.mask.board.web.BoardListForm;
import co.mask.board.web.BoardUpdate;
import co.mask.board.web.BoardUpdateForm;
import co.mask.board.web.BoardView;
import co.mask.board.web.BoardWirte;
import co.mask.board.web.BoardWriteForm;
import co.mask.board.web.Hedaer;
import co.mask.board.web.Notice;
import co.mask.cart.web.BootPay;
import co.mask.cart.web.CartDelete;
import co.mask.cart.web.CartView;
import co.mask.cart.web.NonMemberBootPay;
import co.mask.cart.web.NonMemberCart;
import co.mask.join.web.IdCheck;
import co.mask.join.web.Join;
import co.mask.join.web.JoinForm;
import co.mask.login.web.Login;
import co.mask.login.web.LoginForm;
import co.mask.login.web.Logout;
import co.mask.main.MainPage;
import co.mask.main.Menu;
import co.mask.member.web.MyPageDelete;
import co.mask.member.web.MyPageForm;
import co.mask.member.web.MyPageUpdate;
import co.mask.member.web.MyPageUpdateForm;
import co.mask.product.web.DeleteAdminExec;
import co.mask.product.web.DeleteExec;
import co.mask.product.web.Insertexec;
import co.mask.product.web.ShowProduct;
import co.mask.product.web.ShowProductSeller;
import co.mask.product.web.ToInsertProduct;
import co.mask.product.web.ToUpdateProduct;
import co.mask.product.web.UpdateExec;
import co.mask.sell.web.SellInsert;
import co.mask.sell.web.BuyerView;

@WebServlet("/FrontController1")
public class FrontController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController1() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/menu.do", new Menu());
		map.put("/main.do", new MainPage());
		map.put("/joinForm.do", new JoinForm()); // ����媛��� �� �몄�
		map.put("/idCheck.do", new IdCheck()); // ���대�� 以�蹂듭껜��
		map.put("/join.do", new Join()); // ����媛���
		map.put("/loginForm.do", new LoginForm()); // 濡�洹몄�� �� �몄�
		map.put("/login.do", new Login()); // 濡�洹몄��
		map.put("/adminForm.do", new AdminFrom()); // 愿�由ъ���� 愿�由ъ��李� �� �몄�
		map.put("/adminUserForm.do", new AdminUserForm()); // 愿�由ъ���� ����紐⑸� �� �몄�
		map.put("/userUpForm.do", new UserUpForm()); // 愿�由ъ���� ���� ���� �� �몄�
		map.put("/userUpdate.do", new UserUpdate()); // 愿�由ъ���� ���� ����
		map.put("/userDelete.do", new UserDelete()); // 愿�由ъ���� ���� ����
		map.put("/adminSellerForm.do", new AdminSellerForm()); // 愿�由ъ���� 嫄곕��泥�紐⑸� �� �몄�
		map.put("/sellerUpForm.do", new SellerUpForm()); // 愿�由ъ���� 嫄곕��泥� ���� �� �몄�
		map.put("/sellerUpdate.do", new SellerUpdate()); // 愿�由ъ���� 嫄곕��泥� ����
		map.put("/sellerDelete.do", new SellerDelete()); // 愿�由ъ���� 嫄곕��泥� ����
		map.put("/myPageForm.do", new MyPageForm()); // 硫ㅻ�(����,嫄곕��泥�)�� �댁��蹂� 議고��
		map.put("/myPageUpdateForm.do", new MyPageUpdateForm());// 硫ㅻ��� �댁��蹂� ���� �� �몄�
		map.put("/myPageUpdate.do", new MyPageUpdate());// 硫ㅻ��� �댁��蹂� ����
		map.put("/myPageDelete.do", new MyPageDelete());// 硫ㅻ��� ��������
		map.put("/logout.do", new Logout());//濡�洹몄����

		//controller2
		// Cart
		map.put("/cartView.do", new CartView()); // �λ�援щ�� 由ъ�ㅽ�� ���댁�
		map.put("/bootPay.do", new BootPay()); // bootPay 寃곗��
		map.put("/cartDelete.do", new CartDelete()); // �λ�援щ�� ����
		map.put("/nonMemberBootPay.do", new NonMemberBootPay()); // �λ�援щ�� ����
		map.put("/nonMemberCart.do", new NonMemberCart()); // �λ�援щ�� ����
		// Sell
		map.put("/sellView.do", new BuyerView()); // ��留� �댁�� 由ъ�ㅽ��
		map.put("/sellInsert.do", new SellInsert()); // ��留� �댁�� ����
		// Product
		map.put("/showProduct.do", new ShowProduct()); // ����紐⑸� 議고��
		map.put("/toInsertProduct.do", new ToInsertProduct()); // �����깅� ��硫� 媛�湲�
		map.put("/insertExec.do", new Insertexec()); // �����깅�
		map.put("/toUpdateProduct.do", new ToUpdateProduct()); // �������� ��硫� 媛�湲�
		map.put("/updateExec.do", new UpdateExec()); // ��������
		map.put("/deleteExec.do", new DeleteExec()); // ��������
		
		//controller3
		map.put("/main.do", new MainPage());
		map.put("/menu.do", new Menu()); //硫��� ���명���ㅺ� index���� 諛�濡� menu濡� 蹂�寃쏀�대낫���듬����.
		map.put("/boardView.do", new BoardView());
		map.put("/notice.do", new Notice());
		
		map.put("/boardListForm.do", new BoardListForm());
		map.put("/boardWriteForm.do", new BoardWriteForm());
		map.put("/boardWirte.do", new BoardWirte());
		
		map.put("/boardDelete.do", new BoardDelete());
		
		map.put("/boardUpdate.do", new BoardUpdate());
		map.put("/boardUpdateForm.do", new BoardUpdateForm());
		
		//controller4
		map.put("/cartView.do", new CartView()); // �λ�援щ�� 由ъ�ㅽ�� ���댁�
		map.put("/bootPay.do", new BootPay());
		map.put("/myPageUpdateForm.do", new MyPageUpdateForm());//硫ㅻ��� �댁��蹂� ���� �� �몄�
		map.put("/myPageUpdate.do", new MyPageUpdate());//硫ㅻ��� �댁��蹂� ����
		map.put("/showProduct.do", new ShowProduct()); //����紐⑸� 議고��
		map.put("/toInsertProduct.do", new ToInsertProduct()); //�����깅� ��硫� 媛�湲�
		map.put("/insertExec.do", new Insertexec()); //�����깅�
		map.put("/toUpdateProduct.do", new ToUpdateProduct()); //�������� ��硫� 媛�湲�
		map.put("/updateExec.do", new UpdateExec()); //��������
		map.put("/deleteExec.do", new DeleteExec()); //��������
		map.put("/showProductSeller.do", new ShowProductSeller()); //��留ㅼ���� ����愿�由� 
		map.put("/deleteAdminExec.do",new DeleteAdminExec()); //愿�由ъ���� ��������

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());

		Command command = map.get(path);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do"))
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
