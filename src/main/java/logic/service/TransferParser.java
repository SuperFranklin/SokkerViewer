package main.java.logic.service;

import java.util.List;

import main.java.logic.entity.Transfer;

public interface TransferParser
{

	public List<Transfer> downloadsTransfer(String page);
}
