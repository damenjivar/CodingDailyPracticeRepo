package com.automation.day22.Nov_12_2023Practice;

public class P3WebTable_LearningPractice {

	// How to identify a WebTable in DOM (Document Object Model)
	// WebTables are dynamic in nature

	// WebTable will have a specific id or class
	// thead - header of WebTable
	// tbody - body of WebTable
	// tr - row
	// th - column of header row
	// td - column of row

	// Having good XPath knowledge is very important for WebTables

	// table[@class = 'dataTable'] - represents the whole WebTable
	// table[@class = 'dataTable']/thead - represents the head of the WebTable
	// table[@class = 'dataTable']/thead/tr - represents the header row of the
	// WebTable.
	// table[@class = 'dataTable']/thead/tr/th - represents all the columns of the
	// header row.
	// table[@class = 'dataTable']/thead/tr/th[1] - represents the 1st column of the
	// header row.
	// table[@class = 'dataTable']/thread/tr/th[5] - represents the 5th column of
	// the header row.

	// table[@class = 'dataTable']/tbody - represents the body of the WebTable
	// without the header row.
	// table[@class = 'dataTable']/tbody/tr - represents all the rows of the body of
	// the WebTable.
	// table[@class = 'dataTable']/tbody/tr[1] - represents the first row of the
	// body of the WebTable.
	// table[@class = 'dataTable']tbody/tr/td - represents all the columns of all
	// the rows of the body of the WebTable.
	// table[@class = 'dataTable']/tbody/tr[1]/td - represents all the columns of
	// the first row of the WebTable.
	// table[@class = 'dataTable']/tbody/tr[1]/td[1] - represents the first column
	// of the first row of the WebTable.
	// table[@class = 'dataTable']/tbody/tr/td[1] - represents all the values of the
	// first column of the WebTable.
	// table[@class = 'dataTable']/tbody/tr/td[4] - represents all the values of the
	// 4th column of the WebTable.
}
