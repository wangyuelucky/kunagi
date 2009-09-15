package scrum.client.issues;

import scrum.client.ScrumGwtApplication;
import scrum.client.workspace.Ui;

public class CreateIssueAction extends GCreateIssueAction {

	@Override
	public String getLabel() {
		return "Create new Issue";
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	protected void onExecute() {
		Issue issue = ScrumGwtApplication.get().getProject().createNewIssue();
		Ui.get().showIssueList(issue);
	}

}
