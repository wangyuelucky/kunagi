package scrum.client.risks;

import scrum.client.ScrumGwtApplication;
import scrum.client.common.AScrumAction;
import scrum.client.workspace.WorkareaWidget;

public class CreateRiskAction extends AScrumAction {

	@Override
	public String getLabel() {
		return "Create new Risk";
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	protected void onExecute() {
		Risk risk = ScrumGwtApplication.get().getProject().createNewRisk();
		WorkareaWidget.get().showRiskList(risk);
	}

}