import React, {useEffect, useState} from 'react';
import './App.css';
import {Api} from "./api/Api";
import {CsEntityDto} from "./api/computing-systems";

function App() {
  const [data, setData] = useState<CsEntityDto[]>([]);
  const [content, setContent] = useState<CsEntityDto>();

  useEffect( () => {
    Api.getCsEntityHierarchy().then(response => setData(response.data));
  }, [])

  const handleEntityClick = (entity: CsEntityDto) => {
    setContent(entity);
  };

  const handleInput = (e) => {

  };

  const renderHierarchy = (rootEntities: CsEntityDto[]) => {
    return (
        <ul key={Date.now()}>
          {rootEntities.map(entity => (
              <>
                <li className="list-item" key={entity.id} onClick={() => handleEntityClick(entity)}>{entity.name}</li>
                {renderHierarchy(entity.descendants)}
              </>
          ))}
        </ul>
    );
  };

  return (
    <div className="wrapper">
      <div className="header">Классификация вычислительных систем</div>
      <div className="article">
        <div>
          <h4>{content?.name}</h4>
          <p>{content?.description}</p>
          <br/>
          {content && content?.descendants && content?.descendants.length > 0 &&
          <div>
            <h5>Связанные термины:</h5>
            <ul>
              {content.descendants.map(d => <li className="list-item" onClick={() => handleEntityClick(d)} key={d.id}>{d.name}</li>)}
            </ul>
          </div>}
          {/*{content && content?.descendants &&*/}
          {/*<div>*/}
          {/*  <h5>Головные термины:</h5>*/}
          {/*  <ul>*/}
          {/*    {content?.descendants.map(d => <li className="list-item" onClick={() => handleEntityClick(d)} key={d.id}>{d.name}</li>)}*/}
          {/*  </ul>*/}
          {/*</div>}*/}
        </div>
      </div>
      <div className="aside">
        <div className="search">
          Поиск:
          <input type="text" name="name" onChange={handleInput}/>
        </div>
        {renderHierarchy(data)}
      </div>
      <div className="footer">Пятаев Егор Евгеньевич, 19223. Вычислительные системы, 2020</div>
    </div>
  );
}

export default App;
