package com.oracle.tna.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tna.dao.ItemDAO;
import com.oracle.tna.domain.Item;
import com.oracle.tna.exception.ExamException;
import com.oracle.tna.exception.TNAException;

@Repository
@Scope("singleton")
@Transactional
public class ItemService 
{
	@Resource
	private ItemDAO itemDAO;
	private static final String[] OPTION={"A","B","C","D"};
	public List<Item> showAllItems() throws TNAException
	{
		List<Item> lisetItems = itemDAO.showAllItems();
		return lisetItems;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void DeleteItem(int qid) throws TNAException
	{
		Item item = itemDAO.findItem(qid);
		itemDAO.DeleteItem(item);
	}
	
	public Item FindItem(int qid) throws TNAException
	{
		Item item =  itemDAO.findItem(qid);
		return item;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void ModifyItem(Item item) throws TNAException
	{
		itemDAO.UpdateItem(item);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void AddItem(Item item) throws TNAException
	{
		itemDAO.AddItem(item);
	}

	public static String[] getOption() {
		return OPTION;
	}
	//下载所有试题（题库）
	public void downLoadItems() throws ExamException{
		
		/*地址选择器*/
		//参数定义
		JFileChooser chooser = new JFileChooser();
		String path = null;
		int result = 0;
		//外观 & 功能  定义
		FileSystemView fsv = FileSystemView.getFileSystemView(); 
		chooser.setCurrentDirectory(fsv.getHomeDirectory());
		chooser.setDialogTitle("请选择要保存的地址");
		chooser.setApproveButtonText("确定");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//选项 &对应结果
		result = chooser.showOpenDialog(null);
		if (JFileChooser.APPROVE_OPTION != result) {
			return;
		}
		path=chooser.getSelectedFile().getPath();
		//System.out.println("path: "+path);	测试
		
		/*输入输出对象创建*/
		File file = new File(path + "/item.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			file.createNewFile();
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			List<Item> items = itemDAO.getItems();									//查找所有的题
			String line = null;
			int i = 0;
			for(Item it:items){
				i++;
				line  = i +". " + it.getQuestion() + "  \r\n" + it.getOptionA()
						+ "  \n" + it.getOptionB() + "  \n" + it.getOptionC()
						+ "  \n" + it.getOptionD() + "  \n" + " 答案:" +it.getAnswer() +"\n";				
				bw.append(line);        											//打印题
				bw.newLine();
			}			
		bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try {
			   if (bw!=null) bw.close();
		    } catch (IOException e) {e.printStackTrace();}	
		}	
	}
}
