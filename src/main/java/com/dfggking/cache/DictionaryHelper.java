package com.dfggking.cache;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.dfggking.entity.Dic;
import com.dfggking.sys.service.IDictService;
/**
 * 
 * <p>字典工具类</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月20日 下午1:15:21 
 * @since 1.0
 */
@Component
public class DictionaryHelper {
    private final static Logger log = LogManager.getLogger(DictionaryHelper.class);
    
    @Resource
    private IDictService dictService;
    
    /** 系统字典集合 */
    private static List<Dic> dictionaryList = new ArrayList<Dic>();
    
    /** 工具类不允许外部 通过 new 来创建对象*/
    private DictionaryHelper() {}
    
    private final static DictionaryHelper dictionaryHelper = new DictionaryHelper();
    /**
     * 获取字典工具类的唯一实例
     * <p></p>
     * <pre></pre>
     * @return
     * @author jinyf   
     * @date 2017年3月1日 下午3:25:10 
     * @since
     */
    public static DictionaryHelper getInstance() {
    	return dictionaryHelper;
    }
    
    /**
     * 随系统启动,配置于applicationContext,初始化字典数据,取自字典表
     * <p></p>
     * @return void
     * @author jinyf
     * @since 1.0
     */
    public void init() {
    	try {
    //			dictionaryList = dictService.listDict();
    	} catch (Exception e) {
    		log.error(e);
    	}
    }
    
    /**
     * 刷新字典数据
     * <p>重新从数据库字典表获取全部数据</p>
     * <pre></pre>
     * @author jinyf   
     * @date 2017年2月24日 下午4:18:46 
     * @since 1.0
     */
    public void refresh() {
    	dictionaryList.clear();
    	init();
    }
    
    /**
     * 
     * <p>获取所有的字典List<Dic></p>
     * <pre></pre>
     * @return List<Dic>
     * @author jinyf   
     * @date 2017年2月24日 下午4:16:40 
     * @since 1.0
     */
    public List<Dic> getAllDic() {
    	return dictionaryList;
    }
    
    /**
     * <p>根据CODE取子字典值</p>
     * <pre></pre>
     * @param code
     * @return List<Dic>
     * @author jinyf   
     * @date 2017年2月24日 下午4:28:36 
     * @since 1.0
     */
    public List<Dic> getSysDictListByCode(String code) {
    	Dic v = getSysDictByCode(code);
    	if(v != null){
    		List<Dic> list = new ArrayList<Dic>();
    		for (Dic dic : dictionaryList) {
    			/** Objects JDK8 新特性 推荐使用 */
    			if (!Objects.isNull(dic.getParentId()) && Objects.equals(dic.getParentId(), v.getId())) {
    				list.add(dic);
    			}
    		}
    		return list;
    	}
    	return null;
    }
    
    /**
     * 
     * <p>根据父ID取子字典值</p>
     * <pre></pre>
     * @param fid
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:31:34 
     * @since
     */
    public List<Dic> getSysDictByFid(String fid) {
    	List<Dic> list = new ArrayList<Dic>();
    	for (Dic vo : dictionaryList) {
    		/** Objects JDK8 新特性 推荐使用 */
    		if (!Objects.isNull(vo.getParentId()) && Objects.equals(vo.getParentId(), fid)) {
    			list.add(vo);
    		}
    	}
    	return list;
    }
    
    /**
     * 
     * <p>根据根字典值的文字取字典</p>
     * <pre></pre>
     * @param name
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:33:35 
     * @since
     */
    public Dic getRootSysDictByName(String name) {
    	if(!Objects.isNull(name)){
    		for (Dic vo : dictionaryList) {
    			if (Objects.isNull(vo.getParentId()) && Objects.equals(vo.getDicName(), name.trim())) {
    				return vo;
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * 
     * <p>根据字典值的文字和父字典的文字取</p>
     * <pre></pre>
     * @param fname
     * @param name
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:35:51 
     * @since
     */
    private Dic getSysDictByNames(String fname, String name) {
    	if(!Objects.isNull(fname) && !Objects.isNull(name)){
    		for (Dic vo : dictionaryList) {
    			if (vo.getDicName().equals(name.trim())) {
    				for (Dic fvo : dictionaryList) {
    					if (Objects.equals(fvo.getId(), vo.getParentId()) && Objects.equals(fvo.getDicName(), fname)) {
    						return vo;
    					}
    				}
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * 
     * <p>根据字典ID取字典值</p>
     * <pre></pre>
     * @param id
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:37:51 
     * @since
     */
    private Dic getSysDictById(String id) {
    	for (Dic vo : dictionaryList) {
    		if (Objects.equals(vo.getId(), id)) {
    			return vo;
    		}
    	}
    	return null;
    }
    
    /**
     * 
     * <p>根据字典CODE取字典值</p>
     * <pre></pre>
     * @param code
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:38:39 
     * @since
     */
    public Dic getSysDictByCode(String code) {
    	for (Dic vo : dictionaryList) {
    		if (Objects.equals(vo.getDicCode(), code)) {
    			return vo;
    		}
    	}
    	return null;
    }
    
    /**
     * 
     * <p>根据字典ID取字典名称</p>
     * <pre></pre>
     * @param id
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:39:23 
     * @since
     */
    private String getSysDictNameById(String id){
    	Dic vo = getSysDictById(id);
    	if(vo != null){
    		return vo.getDicName();
    	}
    	return "";
    }
    
    /**
     * 
     * <p>根据字典code取字典名称</p>
     * <pre></pre>
     * @param code
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:39:49 
     * @since
     */
    public String getSysDictNameByCode(String code){
    	Dic vo = getSysDictByCode(code);
    	if(vo != null){
    		return vo.getDicName();
    	}
    	return "";
    }
    
    /**
     * 
     * <p>根据字典code取字典值</p>
     * <pre></pre>
     * @param code
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:40:11 
     * @since
     */
    public String getSysDictValueByCode(String code){
    	Dic vo = getSysDictByCode(code);
    	if(vo != null){
    		return vo.getDicValue();
    	}
    	return "";
    }
    
    /**
     * 
     * <p>根据字典Code取父节点名称</p>
     * <pre></pre>
     * @param code
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:40:35 
     * @since
     */
    public String getSysDictParentNameByCode(String code){
    	Dic vo = getSysDictById(code);
    	if(vo != null && vo.getParentId() != null){
    		String fid = (String)vo.getParentId();
    		return getSysDictNameById(fid);
    	}
    	return "";
    }
    
    /**
     * 
     * <p>取得某节点下所有子节点</p>
     * <pre></pre>
     * @param fid
     * @param result
     * @author jinyf   
     * @date 2017年2月24日 下午4:40:53 
     * @since
     */
    public void getDictIds(String fid, List<Dic> result) {
    	if (result == null) {
    		result = new ArrayList<Dic>();
    	}
    	List<Dic> list = getSysDictByFid(fid); 
    	result.addAll(list);
    	for (Dic vo : list){
    		getDictIds(vo.getDicCode(), result);
    	}
    }
    
    /**
     * 
     * <p>根据父节点与当前节点生成select元素</p>
     * <pre></pre>
     * @param parentNodeName
     * @param nodeName
     * @param selectId
     * @param selected
     * @param definedAttr
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:41:27 
     * @since
     */
    public String getStringOptions(String parentNodeName, String nodeName, String selectId, String selected, String definedAttr){
    	StringBuffer sb=new StringBuffer();
    	sb.append("<select id=\""+selectId+"\" name=\""+selectId+"\" "+definedAttr+">");
    	Dic vo = Objects.isNull(parentNodeName) ? getRootSysDictByName(nodeName) : getSysDictByNames(parentNodeName, nodeName);
    	if(vo != null){
    		String id = vo.getId();
    		List<Dic> voList=getSysDictByFid(Objects.isNull(id) ? vo.getParentId() : id);
    		for(int i=0;i<voList.size();i++){
    			Dic dict = voList.get(i);
    			String nodeId = dict.getId();
    			String nodeText = dict.getDicName();
    		  if(nodeId.equals(selected)) 
    		    sb.append("<option value='"+nodeId+"' selected>"+nodeText+"</option>\n");
    		  else
    			sb.append("<option value='"+nodeId+"'>"+nodeText+"</option>\n");
    		}
    	}
    	sb.append("</select>");
    	return sb.toString();
    }
    
    /**
     * 
     * <p>根据父节点与当前节点生成select元素</p>
     * <pre></pre>
     * @param parentNodeName 父节点名
     * @param nodeName 当前节点名
     * @param selectId select元素ID
     * @param selected 自定义元素
     * @param definedAttr 当前被选中的ID值
     * @param indexOptionStr 初始化选项
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:44:21 
     * @since
     */
    public String getStringOptions(String parentNodeName,String nodeName,String selectId,String selected,String definedAttr,String indexOptionStr){
    	StringBuffer sb=new StringBuffer();
    	sb.append("<select id=\""+selectId+"\" name=\""+selectId+"\" "+definedAttr+">");
    	if(!Objects.isNull(indexOptionStr)){
    		sb.append("<option value=''>"+indexOptionStr+"</option>");
    	}
    	String[] nodeNames = nodeName.split(",");
    	for (int j=0;j<nodeNames.length;j++) {
    		Dic t = Objects.isNull(parentNodeName) ? getRootSysDictByName(nodeNames[j]) : getSysDictByNames(parentNodeName,nodeNames[j]);
    		if(t != null){
    			String id = t.getId();
    			List<Dic> table=getSysDictByFid(Objects.isNull(id) ? t.getParentId() : id);
    			for(int i=0;i<table.size();i++){
    				Dic dict = table.get(i);
    				String nodeId = dict.getId();
    				String nodeText = dict.getDicName();
    				if(nodeId.equals(selected)) 
    					sb.append("<option value='"+nodeId+"' selected>"+nodeText+"</option>\n");
    				else
    					sb.append("<option value='"+nodeId+"'>"+nodeText+"</option>\n");
    			}
    		}
    	}
    	sb.append("</select>");
    	return sb.toString();
    }
    
    /**
     * 
     * <p>与上一个方法不同的地方是多了一个defaultval参数，默认选项的value值</p>
     * <pre></pre>
     * @param parentNodeName
     * @param nodeName
     * @param selectId
     * @param selected
     * @param definedAttr
     * @param indexOptionStr
     * @param defaultVal
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:47:05 
     * @since
     */
    public String getSelectOptions(String parentNodeName,String nodeName,String selectId,String selected,String definedAttr,String indexOptionStr,String defaultVal){
    	StringBuffer sb=new StringBuffer();
    	sb.append("<select id=\""+selectId+"\" name=\""+selectId+"\" "+definedAttr+">");
    	if(!Objects.isNull(indexOptionStr)){
    		sb.append("<option value=\""+defaultVal+"\">"+indexOptionStr+"</option>");
    	}
    	String[] nodeNames = nodeName.split(",");
    	for (int j=0;j<nodeNames.length;j++) {
    		Dic t = Objects.isNull(parentNodeName) ? getRootSysDictByName(nodeNames[j]) : getSysDictByNames(parentNodeName,nodeNames[j]);
    		if(t != null){
    			String id = t.getId();
    			List<Dic> table=getSysDictByFid(Objects.isNull(id) ? t.getParentId() : id);
    			for(int i=0;i<table.size();i++){
    				Dic dict = table.get(i);
    				String nodeId = dict.getId();
    				String nodeText = dict.getDicName();
    				if(nodeId.equals(selected)) 
    				    sb.append("<option value=\""+nodeId+"\" selected>"+nodeText+"</option>\n");
    				else
    					sb.append("<option value=\""+nodeId+"\">"+nodeText+"</option>\n");
    			}
    		}
    	}
    	sb.append("</select>");
    	return sb.toString();
    }
    
    
    /**
     * 
     * <p>根据当前节点获取(不包括当前级别的后代节点)</p>
     * <pre></pre>
     * @param currentCode
     * @param level
     * @param levels
     * @param containCur
     * @param childs
     * @return
     * @author jinyf   
     * @date 2017年2月24日 下午4:49:31 
     * @since
     */
    private List<Dic> getDescendantDicByCode(String currentCode,int level,int [] levels,boolean containCur,List<Dic> childs){
        if(level==0){
            return null;
        }
        if(childs==null){
            childs=new ArrayList<Dic>();
            Dic currenDictNode=getSysDictByCode(currentCode);
            if(containCur&&currenDictNode!=null){
                childs.add(currenDictNode);
            }
        }
        List<Dic> nextLevelDics = getSysDictListByCode(currentCode);
        	if(nextLevelDics!=null){
        /*应该将大于level的中数组元素取出掉*/
            for(int i=0;i<levels.length;i++){
                if(levels[i]==level-1){
                  childs.addAll(nextLevelDics);
                  break;
                }
            }
            if(level>1){
                for(Dic DictNode : nextLevelDics){
                    getDescendantDicByCode(DictNode.getDicCode(),level - 1,levels,false,childs);
                }
            }
        }
        	return childs;
    }

}
