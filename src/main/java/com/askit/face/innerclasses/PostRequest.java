package com.askit.face.innerclasses;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;

import com.askit.entities.Answer;
import com.askit.entities.Group;
import com.askit.entities.PrivateQuestion;
import com.askit.entities.PublicQuestion;
import com.askit.entities.User;
import com.askit.etc.Constants;
import com.askit.exception.DatabaseLayerException;
import com.askit.exception.DuplicateHashException;
import com.askit.exception.MissingParametersException;
import com.askit.exception.WrongHashException;
import com.askit.face.JSONBuilder;
import com.askit.queries.DatabaseQueryManager;
import com.askit.queries.QueryManager;
import com.sun.org.apache.bcel.internal.classfile.ConstantObject;
import com.sun.org.apache.xml.internal.resolver.readers.OASISXMLCatalogReader;

public class PostRequest extends Request {
	public PostRequest(final String pathInfo, final Map<String, String[]> parameters, final PrintWriter out) {
		super(pathInfo, parameters, out);

	}

	public void handleRequest() throws MissingParametersException, WrongHashException, DuplicateHashException,
			DatabaseLayerException, ServletException {
		super.handleRequest();

		final JSONBuilder jsonBuilder = new JSONBuilder();
		final QueryManager queryManager = new DatabaseQueryManager();

		Long groupID = null;
		Long questionID = null;
		Long userID = null;
		boolean isPublic = false;
		boolean isExpired = false;
		String language = null;
		Long answerID = null;
		String userName = null;
		String passwordHash = null;
		String phoneNumberHash = null;
		Long adminID = null;
		String groupName = null;
		String pictureUrl = null;
		String question = null;
		String additionalInformation = null;
		Long hostID = null;
		boolean optionExtension = false;
		Long eDate = null;
		boolean isBet = false;
		int definitionOfEnd = 0;
		int sumOfUsersToAnswer = 0;
		Long selectedAnswerID = null;
		boolean isOneTime = false;
		String answerText = null;
		Long contactID = null;

		if (parameters.containsKey(Constants.PARAMETERS_GROUPID)) {
			groupID = Long.parseLong(parameters.get(Constants.PARAMETERS_GROUPID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_QUESTIONID)) {
			questionID = Long.parseLong(parameters.get(Constants.PARAMETERS_QUESTIONID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_USERID)) {
			userID = Long.parseLong(parameters.get(Constants.PARAMETERS_USERID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_PUBLIC)) {
			isPublic = Boolean.parseBoolean(parameters.get(Constants.PARAMETERS_PUBLIC)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_ACTIVE)) {
			isExpired = Boolean.parseBoolean(parameters.get(Constants.PARAMETERS_ACTIVE)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_LANGUAGE)) {
			language = parameters.get(Constants.PARAMETERS_LANGUAGE)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_ANSWERID)) {
			answerID = Long.parseLong(parameters.get(Constants.PARAMETERS_ANSWERID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_USERNAME)) {
			userName = parameters.get(Constants.PARAMETERS_USERNAME)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_PASSWORDHASH)) {
			passwordHash = parameters.get(Constants.PARAMETERS_PASSWORDHASH)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_PHONEHASH)) {
			phoneNumberHash = parameters.get(Constants.PARAMETERS_PHONEHASH)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_ADMINID)) {
			adminID = Long.parseLong(parameters.get(Constants.PARAMETERS_ADMINID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_GROUPNAME)) {
			groupName = parameters.get(Constants.PARAMETERS_GROUPNAME)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_PICTUREURL)) {
			pictureUrl = parameters.get(Constants.PARAMETERS_PICTUREURL)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_QUESTION)) {
			question = parameters.get(Constants.PARAMETERS_QUESTION)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_INFORMATION)) {
			additionalInformation = parameters.get(Constants.PARAMETERS_INFORMATION)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_HOSTID)) {
			hostID = Long.parseLong(parameters.get(Constants.PARAMETERS_HOSTID)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_EXTENSION)) {
			optionExtension = Boolean.parseBoolean(parameters.get(Constants.PARAMETERS_EXTENSION)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_ENDDATE)) {
			eDate = Long.parseLong(parameters.get(Constants.PARAMETERS_ENDDATE)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_BET)) {
			isBet = Boolean.parseBoolean(parameters.get(Constants.PARAMETERS_BET)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_DEFINITIONEND)) {
			definitionOfEnd = Integer.parseInt(parameters.get(Constants.PARAMETERS_DEFINITIONEND)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_SUMANSWERS)) {
			sumOfUsersToAnswer = Integer.parseInt(parameters.get(Constants.PARAMETERS_SUMANSWERS)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_SELECTEDANSWER)) {
			selectedAnswerID = Long.parseLong(parameters.get(Constants.PARAMETERS_SELECTEDANSWER)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_ONETIME)) {
			isOneTime = Boolean.parseBoolean(parameters.get(Constants.PARAMETERS_ONETIME)[0]);
		}
		if (parameters.containsKey(Constants.PARAMETERS_ANSWER)) {
			answerText = parameters.get(Constants.PARAMETERS_ANSWER)[0];
		}
		if (parameters.containsKey(Constants.PARAMETERS_CONTACTID)) {
			contactID = Long.parseLong(parameters.get(Constants.PARAMETERS_CONTACTID)[0]);
		}
		/*
		 * POST /USER
		 * 
		 * @params: USERNAME: String PHONEHASH: String PASSWORDHASH: String
		 * LANGUAGE: String
		 */

		/*
		 * POST /USER
		 * 
		 * @params: USERID: Long CONTACTID: Long
		 */

		matcher = regExUserPattern.matcher(this.pathInfo);
		if (matcher.find()) {
			if (userName != null && phoneNumberHash != null && passwordHash != null && language != null) {
				final Date accessionDate = null;
				final String profilePictureURI = null;
				final int scoreOfGlobal = 0;
				User user = new User(userID, passwordHash, phoneNumberHash, userName, accessionDate, profilePictureURI,
						language, scoreOfGlobal);
				queryManager.registerUser(user);
			} else if (userID != null && contactID != null) {
				queryManager.addContact(userID, contactID);
			} else if (userID != null && groupID != null) {
				queryManager.addUserToGroup(groupID, userID);
			} else if (userID != null && questionID != null && isOneTime) {
				queryManager.addUserToOneTimeQuestion(userID, questionID);
			} else if (userID != null && questionID != null && isPublic) {
				queryManager.addUserToPublicQuestion(questionID, userID);
			} else {
				throw new MissingParametersException("Missings Parameters");
			}
			return;

		}

		/*
		 * POST /GROUP
		 * 
		 * @params: GROUPNAME: String ADMINID: Long PICTUREURL: String
		 */
		matcher = regExGroupPattern.matcher(pathInfo);
		if (matcher.find()) {
			if (adminID != null && groupName != null && pictureUrl != null) {
				Date createDate = Calendar.getInstance().getTime();
				Group group = new Group(createDate, adminID, groupName, pictureUrl);
				queryManager.createNewGroup(group);
			} else {
				throw new MissingParametersException("Missings Parameters");
			}
			return;
		}

		/*
		 * POST /QUESTION
		 * 
		 * @params: PUBLIC: Boolean, defines if Public or Private Question
		 * QUESTION: String INFORMATION: String, additional Information HOSTID:
		 * Long ENDDATE: Long EXTENSION: Boolean ACTIVE: Boolean LANGUAGE:
		 * String PICTUREURL: String DEFINITIONEND: Integer SUMANSWERS: Integer
		 * SELECTEDANSWER: Long ISBET: Boolean
		 */
		matcher = regExQuestionPattern.matcher(pathInfo);
		if (matcher.find()) {
			if (adminID != null && groupName != null && pictureUrl != null) {
				Date createDate = Calendar.getInstance().getTime();
				if (isPublic && question != null && additionalInformation != null && hostID != null
						&& pictureUrl != null && eDate != null && language != null) {
					Date endDate = new Date(createDate.getTime() + eDate);
					PublicQuestion publicQuestion = new PublicQuestion(question, additionalInformation, hostID,
							pictureUrl, createDate, endDate, optionExtension, isExpired, language);
					queryManager.createPublicQuestion(publicQuestion);
				} else if (!isPublic && groupID != null) {
					Date endDate = new Date(createDate.getTime() + eDate);
					PrivateQuestion privateQuestion = new PrivateQuestion(question, additionalInformation, hostID,
							pictureUrl, groupID, endDate, optionExtension, definitionOfEnd, sumOfUsersToAnswer,
							isExpired, selectedAnswerID, language, isBet);
					queryManager.createNewQuestionInGroup(privateQuestion);
				} else if (!isPublic && isOneTime) {
					Date endDate = new Date(createDate.getTime() + eDate);
					PrivateQuestion privateQuestion = new PrivateQuestion(question, additionalInformation, hostID,
							pictureUrl, groupID, endDate, optionExtension, definitionOfEnd, sumOfUsersToAnswer,
							isExpired, selectedAnswerID, language, isBet);
					queryManager.createOneTimeQuestion(privateQuestion);
				}

			} else {
				throw new MissingParametersException("Missings Parameters");
			}
			return;
		}

		// Answer
		/*
		 * POST /ANSWER
		 * 
		 * @params: PUBLIC: Boolean, defines if related to Public or Private
		 * Question QUESTIONID: Long ANSWER: String, answer as Text ANSWERID:
		 * Long, when related to another answer
		 */
		matcher = regExAnswerPattern.matcher(pathInfo);
		if (matcher.find()) {
			if (questionID != null && answerText != null && !isPublic) {
				Answer answer = new Answer(questionID, answerText);
				queryManager.addAnswerToPrivateQuestion(answer);
			} else if (questionID != null && answerText != null && isPublic) {
				Answer answer = new Answer(questionID, answerText);
				queryManager.addAnswerToPublicQuestion(answer);
			} else if (questionID != null && answerText != null && !isPublic && answerID != null) {
				Answer answer = new Answer(answerID, questionID, answerText);
				queryManager.addAnswerToPrivateQuestion(answer);
			} else if (questionID != null && answerText != null && isPublic && answerID != null) {
				Answer answer = new Answer(answerID, questionID, answerText);
				queryManager.addAnswerToPublicQuestion(answer);
			}

			return;
		}

	}
}