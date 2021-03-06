package scrum.client.project;

import scrum.client.collaboration.EmoticonsWidget;
import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;

import com.google.gwt.user.client.ui.Widget;

public class QualityBlock extends ABlockWidget<Quality> implements TrashSupport {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Quality quality = getObject();
		header.appendCell(new EmoticonsWidget(quality), null, true, true, null);
		header.addMenuAction(new DeleteQualityAction(quality));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		Quality quality = getObject();
		header.setDragHandle(quality.getReference());
		header.setCenter(quality.getLabel());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new QualityWidget(getObject());
	}

	public AScrumAction getTrashAction() {
		return new DeleteQualityAction(getObject());
	}

	public static final BlockWidgetFactory<Quality> FACTORY = new BlockWidgetFactory<Quality>() {

		public QualityBlock createBlock() {
			return new QualityBlock();
		}
	};
}
