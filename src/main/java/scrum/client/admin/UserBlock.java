package scrum.client.admin;

import ilarkesto.gwt.client.ATextViewEditWidget;
import scrum.client.common.AExtensibleBlockWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.common.FieldsWidget;
import scrum.client.img.Img;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class UserBlock extends AExtensibleBlockWidget<User> {

	private User user;

	private FieldsWidget fields;
	private Label summary;

	@Override
	protected User getObject() {
		return user;
	}

	@Override
	protected void setObject(User object) {
		this.user = object;
	}

	@Override
	protected void onCollapsedInitialization() {
		summary = new Label();
	}

	@Override
	protected void onUpdateHead() {
		setBlockTitle(user.getName());
		setIcon(Img.bundle.user16());
		summary.setText(user.getName());
		setContent(null);
		addMenuAction(new DeleteUserAction(user));
	}

	@Override
	protected void onExtendedInitialization() {
		fields = new FieldsWidget();
		fields.setAutoUpdateWidget(this);

		fields.add("Name", new ATextViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(user.getName());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorText(user.getName());
			}

			@Override
			protected void onEditorSubmit() {
				user.setName(getEditorText());
			}

		});

		fields.add("E-Mail", new ATextViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(user.getEmail());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorText(user.getEmail());
			}

			@Override
			protected void onEditorSubmit() {
				user.setEmail(getEditorText());
			}

		});

	}

	@Override
	protected void onUpdateBody() {
		fields.update();
		setContent(fields);
	}

	public Image getClipboardIcon() {
		return Img.bundle.user16().createImage();
	}

	public String getClipboardLabel() {
		return user.getName();
	}

	public User getUser() {
		return user;
	}

	public static BlockWidgetFactory<User> FACTORY = new BlockWidgetFactory<User>() {

		@Override
		public UserBlock createBlock() {
			return new UserBlock();
		}
	};
}
